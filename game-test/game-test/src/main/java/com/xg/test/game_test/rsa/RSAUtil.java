package com.xg.test.game_test.rsa;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * RSA 加密 解密  签名 验证 工具
 * @auther qikai
 * @date 2016年8月5日
 */
public class RSAUtil {

	/**
	 * 加密算法RSA
	 */
	private static final String KEY_ALGORITHM = "RSA";

	/**
	 * 默认签名算法
	 */
	private static final String DEFAULT_SIGNATURE_ALGORITHM = "SHA1withRSA";

	/**
	 * <p>
	 * 生成密钥对(公钥和私钥)
	 * </p>
	 * 
	 * @return 公钥和私钥键值对:KEY分别为:PUBLIC_KEY PRIVATE_KEY
	 * @throws NoSuchAlgorithmException  
	 * @throws Exception
	 */
	public static Map<String, Object> genKeyPair() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		Map<String, Object> keyMap = new HashMap<String, Object>(2);
		keyMap.put("PUBLIC_KEY", publicKey);
		keyMap.put("PRIVATE_KEY", privateKey);
		return keyMap;
	}

	/**
	 * <p>
	 * 使用公钥加密
	 * <p>
	 * 
	 * @param data 加密的数据的字节码
	 * @param publicKEY 公钥  (BASE64编码)
	 * @return 加密后的字节码
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws IOException 
	 * @throws Exception
	 */
	public static byte[] encryptPublicKey(byte[] data, String publicKEY)
			throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		byte[] keyBytes = Base64Util.decode(publicKEY);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		RSAPublicKey publicKey = (RSAPublicKey) keyFactory.generatePublic(x509KeySpec);
		int maxEncryptBlock = publicKey.getModulus().bitLength() / 8 - 11;
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		int inputLen = data.length;
		if (inputLen > maxEncryptBlock) {
			ByteArrayOutputStream out = null;
			byte[] decryptedData = null;
			try {
				out = new ByteArrayOutputStream();
				int offSet = 0;
				byte[] cache;
				int i = 0;
				// 对数据分段解密  
				while (inputLen - offSet > 0) {
					if (inputLen - offSet > maxEncryptBlock) {
						cache = cipher.doFinal(data, offSet, maxEncryptBlock);
					} else {
						cache = cipher.doFinal(data, offSet, inputLen - offSet);
					}
					out.write(cache, 0, cache.length);
					i++;
					offSet = i * maxEncryptBlock;
				}
				decryptedData = out.toByteArray();

			} finally {
				out.close();
			}
			return decryptedData;
		} else {
			return cipher.doFinal(data);
		}
	}

	/**
	 * <p>
	 * 使用私钥加密
	 * <p>
	 * 
	 * @param data 加密的数据的字节码
	 * @param privateKEY 私钥 (BASE64编码)
	 * @return 加密后的字节码
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws IOException 
	 * @throws Exception
	 */
	public static byte[] encryptPrivateKey(byte[] data, String privateKEY)
			throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		byte[] keyByte = Base64Util.decode(privateKEY);
		PKCS8EncodedKeySpec PKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(keyByte);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		RSAPrivateKey privateKey = (RSAPrivateKey) keyFactory.generatePrivate(PKCS8EncodedKeySpec);
		int maxEncryptBlock = privateKey.getModulus().bitLength() / 8 - 11;
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		int inputLen = data.length;
		if (inputLen > maxEncryptBlock) {
			ByteArrayOutputStream out = null;
			byte[] decryptedData = null;
			try {
				out = new ByteArrayOutputStream();
				int offSet = 0;
				byte[] cache;
				int i = 0;
				// 对数据分段解密  
				while (inputLen - offSet > 0) {
					if (inputLen - offSet > maxEncryptBlock) {
						cache = cipher.doFinal(data, offSet, maxEncryptBlock);
					} else {
						cache = cipher.doFinal(data, offSet, inputLen - offSet);
					}
					out.write(cache, 0, cache.length);
					i++;
					offSet = i * maxEncryptBlock;
				}
				decryptedData = out.toByteArray();

			} finally {
				out.close();
			}
			return decryptedData;
		} else {
			return cipher.doFinal(data);
		}
	}

	/**
	 * <p>
	 * 用私钥对信息生成数字签名
	 * </p>
	 * 
	 * @param data 已加密数据
	 * @param privateKey 私钥(BASE64编码)
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws InvalidKeyException 
	 * @throws SignatureException 
	 * @throws Exception
	 */
	public static byte[] sign(byte[] data, String privateKey)
			throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
		byte[] keyBytes = Base64Util.decode(privateKey);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance(DEFAULT_SIGNATURE_ALGORITHM);
		signature.initSign(privateK);
		signature.update(data);
		return signature.sign();
	}

	/**
	 * <p>
	 * 校验数字签名
	 * </p>
	 * @param encryptData 已加密数据
	 * @param publicKey 公钥(BASE64编码)
	 * @param sign 数字签名
	 * @return
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws InvalidKeyException 
	 * @throws SignatureException 
	 * @throws Exception
	 */
	public static boolean verify(byte[] encryptData, String publicKey, byte[] signData)
			throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, SignatureException {
		byte[] keyBytes = Base64Util.decode(publicKey);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance(DEFAULT_SIGNATURE_ALGORITHM);
		signature.initVerify(publicK);
		signature.update(encryptData);
		return signature.verify(signData);
	}

	/** 
	 * 解密<br> 
	 * 用私钥解密 
	 * (分段解密 每次 需要 重新初始化 Cipher)
	 * @param data 需要解密的数据
	 * @param privateKey 私钥(BASE64编码)
	 * @return 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws IOException 
	 * @throws Exception 
	 */
	public static byte[] decryptByPrivateKey(byte[] data, String privateKey)
			throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		// 对密钥解密  
		byte[] keyBytes = Base64Util.decode(privateKey);
		// 取得私钥  
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		RSAPrivateKey RSAPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
		// 对数据解密  
		int length = RSAPrivateKey.getModulus().bitLength();
		int maxDecryptBlock = length / 8;
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, RSAPrivateKey);
		int inputLen = data.length;
		if (inputLen > maxDecryptBlock) {
			ByteArrayOutputStream out = null;
			byte[] decryptedData = null;
			try {
				out = new ByteArrayOutputStream();
				int offSet = 0;
				byte[] cache;
				int i = 0;
				// 对数据分段解密  
				while (inputLen - offSet > 0) {
					if (inputLen - offSet > maxDecryptBlock) {
						cache = cipher.doFinal(data, offSet, maxDecryptBlock);
					} else {
						//按单部分操作加密或解密数据，或者结束一个多部分操作。数据将被加密或解密（具体取决于此 Cipher 的初始化方式）
						//处理 input 缓冲区中从 inputOffset 开始（包含）的前 inputLen 个字节，以及在上一次 update 操作过程中缓存的任何输入字节，其中应用了填充（如果需要）。
						//结果将存储在新缓冲区中
						//结束时，此方法将此 Cipher 对象重置为上一次调用 init 初始化得到的状态。即该对象被重置，
						//并可用于加密或解密（具体取决于调用 init 时指定的操作模式）更多的数据。
						//注：如果抛出了任何异常，则再次使用此 Cipher 对象前需要将其重置。
						cache = cipher.doFinal(data, offSet, inputLen - offSet);
					}
					out.write(cache, 0, cache.length);
					i++;
					offSet = i * maxDecryptBlock;
				}
				decryptedData = out.toByteArray();

			} finally {
				out.close();
			}
			return decryptedData;
		} else {
			return cipher.doFinal(data);
		}
	}

	/**
	 * <p>
	 * 解密<br> 
	 * 用私钥解密 <br>
	 * data分段之后直接解密然后拼接
	 * </p>
	 * @param data 需要解密的数据
	 * @param privateKey 私钥(BASE64编码)
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	public static byte[] decryptByPrivateKeyV3(byte[] data, String privateKey)
			throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		// 对密钥解密  
		byte[] keyBytes = Base64Util.decode(privateKey);
		// 取得私钥  
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		RSAPrivateKey RSAPrivateKey = (RSAPrivateKey) keyFactory.generatePrivate(pkcs8KeySpec);
		// 对数据解密  
		int length = RSAPrivateKey.getModulus().bitLength();
		int maxDecryptBlock = length / 8;
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, RSAPrivateKey);
		int inputLen = data.length;
		if (inputLen > maxDecryptBlock) {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ByteArrayInputStream in = new ByteArrayInputStream(data);
			byte[] decryptedData = null;
			try {
				int offSet = 0;
				int remainder = inputLen - offSet;
				while (remainder > 0) {
					byte[] tempByte;
					if (remainder > maxDecryptBlock) {
						tempByte = new byte[maxDecryptBlock];
					} else {
						tempByte = new byte[remainder];
					}
					in.read(tempByte, 0, tempByte.length);
					out.write(cipher.doFinal(tempByte));
					offSet = offSet + tempByte.length;
					remainder = inputLen - offSet;
				}
				decryptedData = out.toByteArray();
			} finally {
				out.close();
				in.close();
			}
			return decryptedData;
		} else {
			return cipher.doFinal(data);
		}
	}

	/** 
	 * <p>
	 * 解密<br> 
	 * 用公钥解密 
	 * <p> 
	 * @param data 需要解密的数据
	 * @param privateKey 私钥(BASE64编码)
	 * @return 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws IOException 
	 */
	public static byte[] decryptByPublicKey(byte[] data, String privateKey)
			throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException, IOException {
		// 对密钥解密  
		byte[] keyBytes = Base64Util.decode(privateKey);
		// 取得公钥  
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
		PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
		// 对数据解密  
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		return cipher.doFinal(data);
	}
}
