/*
 * iReport - Visual Designer for JasperReports.
 * Copyright (C) 2002 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of iReport.
 *
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.ireport.jasperserver;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.w3c.tools.codec.Base64Decoder;
import org.w3c.tools.codec.Base64Encoder;
import org.w3c.tools.codec.Base64FormatException;

/**
 *
 * @author gtoffoli
 */
public class Encrypter {
        Cipher ecipher;
        Cipher dcipher;
        
        // 8-byte Salt
        byte[] salt = {
            (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
            (byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03
        };
    
        // Iteration count
        int iterationCount = 19;
    
                
        public Encrypter(String passPhrase)  {
            try {
                 //KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
                 KeySpec keySpec = new DESKeySpec((passPhrase.getBytes()));
                 SecretKey key = SecretKeyFactory.getInstance(
                    "DES").generateSecret(keySpec);
                
                ecipher = Cipher.getInstance("DES");
                dcipher = Cipher.getInstance("DES");
                ecipher.init(Cipher.ENCRYPT_MODE, key);
                dcipher.init(Cipher.DECRYPT_MODE, key);
    
            } catch (InvalidKeySpecException e) {
                e.printStackTrace();
            } catch (javax.crypto.NoSuchPaddingException e) { e.printStackTrace();
            } catch (java.security.NoSuchAlgorithmException e) { e.printStackTrace();
            } catch (java.security.InvalidKeyException e) { e.printStackTrace();
            }
        }
    
        public String encrypt(String str) {
            try {
                // Encode the string into bytes using utf-8
                byte[] utf8 = str.getBytes("UTF8");
    
                // Encrypt
                byte[] enc = ecipher.doFinal(utf8);
    
                return encodeBase64(enc);
            } catch (javax.crypto.BadPaddingException e) { e.printStackTrace();
            } catch (IllegalBlockSizeException e) { e.printStackTrace();
            } catch (UnsupportedEncodingException e) { e.printStackTrace();
            } catch (java.io.IOException e) { e.printStackTrace();
            }
            return null;
        }
    
        public String decrypt(String str) {
            try {
                // Decode base64 to get bytes
                byte[] dec = decodeBase64(str);
    
                
                // Decrypt
                byte[] utf8 = dcipher.doFinal(dec);
    
                // Decode using utf-8
                return new String(utf8, "UTF8");
            } catch (Base64FormatException e) { e.printStackTrace();
            } catch (javax.crypto.BadPaddingException e) { e.printStackTrace();
            } catch (IllegalBlockSizeException e) { e.printStackTrace();
            } catch (UnsupportedEncodingException e) { e.printStackTrace();
            } catch (java.io.IOException e) { e.printStackTrace();
            }
            return null;
        }
        
        private String encodeBase64(byte[] bytes) 
        {
            try {
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                Base64Encoder encoder = new org.w3c.tools.codec.Base64Encoder(new ByteArrayInputStream(bytes),os);
                encoder.process();
                return os.toString();
            } catch (IOException ex) {
            }
            return null;
        }
        
        private byte[] decodeBase64(String s) throws Base64FormatException
        {
            try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Base64Decoder encoder = new org.w3c.tools.codec.Base64Decoder(new ByteArrayInputStream(s.getBytes()),os);
            encoder.process();
            return os.toByteArray();
            } catch (IOException ex) {
            }
            return null;
        }
    }

