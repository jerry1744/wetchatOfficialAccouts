package com.xg.test.game_test.rsa;

import java.nio.charset.Charset;

/**
 * RSAUtil测试类
 * @auther qikai
 * @date 2016年8月5日
 */
public class RSATest {

	//mg
	public final static String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAI1lI2CeJGqL1kYTQteBb9UKhZL4gbW66HlZaLd0wzbwaoiTBCH2tQuVRisx11fO4IpOqq95x3+9HR6bbJXBgxUOCV3t18W33KEZ8VCNxr0KvWhNls4dFH8PisM5QqhqEnb8ieEiht5inCzBRX48ChsQkOnam07JvMXP3U8goBodAgMBAAECgYAkg2WrYatNyGbBGeA8/rP+dAUiewIkB+xYyfn8xi5TVaptMmnyy17dauL/7JMLneTmUoJJZk1ac1+9s61KzvomZ3OovvNsYU/ZgwdK5GmLUWlx9Cl5qkwACuzCJNGxDiVajMPCHXZLH28tO9LOWXdMa6dsoJJvJjdMhGIvZJHMkQJBAMTWR8IdD7xgUAU4t6+uwfH4NEskhNdGeV/q1/O5ALGPVtkkyd1TJ8HPsuYLLwxLZUo0DvilK2w6k5aMqW2uVN8CQQC35NmBKTReKsXQRuCxQJWVdhI5F3/5LeN0vYz60MgYA7CYE11RTAcinAAxwB2B045XRsQh7ifVNmbO56xQHtSDAkEAtSTd9O35xUp9WdDQeoVBRwU8WsrI1bStjm/5PPpMgRuAuWT5wQz90YbrBHnWWmIoXRl7jaezRm7B1BKu+Zkt0QJBAIaPQ4SadQJOxA6CPpoVCx+hlPYHtxHLPTvIE6fYLAI+ePLegJMjUblGc3H0BONhvS8pzgyR6r2+H/5YUaMS3CcCQBbIqhGvJu+Lq1ioo81TgwFmL0iwC8u9tKT+X1y6oSOx1Osjf1/mQBm2dNAc99JyOgvfRunrRHcoKJhhdLUGdmY=";
	public final static String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNFs7manJerSGmFOx0mvrCthq8OTUDEtLJ7d7OaFnoRTuWgYhQ8RiCxYY78Y8UywMk2eiWWcnx7aB86VpqEtua0zl4XSkc54FHeBkyISjxFdBYiT1PP9ZQY9LEziTGJUnKVItpSKKttzFErY+0YK9BOovr/yK37RPGDiWpTTJR0QIDAQAB";
	
	//custom-gener
	//public final static String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCCeo9JOmik/ToqoouykPMgq2VmBgAiyMOM4el7CKHsJDhBrUYMYXWDgbGdPBjNKvHpONyfYmZzzFbiWlrZc7ihZB05ECaYuheF2t0S/kVnFvleXL7L9QDg5N/iN5aonQuTXqOEEg3md5YIld3Asdw3BqbJvS+qHMJ/0vcmnnZ2MwIDAQAB";
	//public final static String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAIJ6j0k6aKT9Oiqii7KQ8yCrZWYGACLIw4zh6XsIoewkOEGtRgxhdYOBsZ08GM0q8ek43J9iZnPMVuJaWtlzuKFkHTkQJpi6F4Xa3RL+RWcW+V5cvsv1AODk3+I3lqidC5Neo4QSDeZ3lgiV3cCx3DcGpsm9L6ocwn/S9yaednYzAgMBAAECgYA2lcFF2EqY41snJPMeU+dyfmGgKdh6tNSiJox/rR/YY1qplyyb11XLG0HLzq1tf47Oi7w4bXkA7rZWYYhqOjA9q46FC92Nb6W2EhGKPbd5CZNrwe+jDb1xI2Z+WIkNTuP377vKoTQez9EzXN2eJe00+lYBQGqr78x/JKl3mf+6mQJBAPunLxowcDuDoI/9ld4iGtnMn8FvVU1GbKKPYygH03mv7idiyqBPd2XzGB0PcaL1YTgTqAYO2wWzT5GX0Z4vslcCQQCEu4o5KmggR3to7IoVUZNcSqh29OuJIB6XTkRgMN+Axlp0f6BO9J4vc0VY2psa7yMMkwrMOMZAq+fj2DW8TEmFAkEA0ABivVnWGkr0tq9aZU15Nhac4Ux9jC6ucjrkMV0unYEd7q4IXzLvtHOWtcZjHdeF8MzGb6NtwytvlB6RYxd3ZwJAS49ndHuLozSOMIDXaqNxvAxUMsPigcFjKMdJbWjlEy3XuJIe9FOU6XY5eAeaXI7d6P6cGv4G/jHeZHpkvLjA8QJBAPbD3qSe4J5BK4gDkg1Imo0N5InYMqZVGTBRRB2Ryxzm/oQXVbrfLjOVpRpI7w7R8DQsEtyvmSQtZIj8vTtwtFg=";
	
	public static void main(String[] args) throws Exception {
		String source = "appkey=38D2ADBFF8&userid=A443CCCA8AB6633&token=651e3766-1d8d-46ba-aa3e-83f034234e7b";
		Charset UTF8 = Charset.forName("UTF-8");
		byte[] data = source.getBytes(UTF8);
		byte[] signByteArray = RSAUtil.sign(data, PRIVATE_KEY);
		String signBase64Str = Base64Util.encodeToString(signByteArray);
		System.out.println("使用私钥生成的数字签名信息  is \n\r " + signBase64Str);
		byte[] encryptByPubKeyByteArray = RSAUtil.encryptPublicKey(data, PUBLIC_KEY);
		String encryptByPubKeyStr = Base64Util.encodeToString(encryptByPubKeyByteArray);
		System.out.println("使用公钥加密的数据  is \n\r " + encryptByPubKeyStr);
		
		System.out.println("加密方 完成--下面开始解密方");
		
		byte[] willDecrtptData = Base64Util.decode(encryptByPubKeyStr);
		byte[] decryptByPriKeyByteArray = RSAUtil.decryptByPrivateKey(willDecrtptData, PRIVATE_KEY);
		String decryptByPriKeyStr = new String(decryptByPriKeyByteArray, UTF8);
		System.out.println("解密后的字符串为: " + decryptByPriKeyStr);
		byte[] encryptPrivateKey = RSAUtil.encryptPrivateKey(decryptByPriKeyByteArray, PRIVATE_KEY);
		byte[] signData = RSAUtil.sign(encryptPrivateKey, PRIVATE_KEY);
		boolean verify = RSAUtil.verify(encryptPrivateKey, PUBLIC_KEY, signData);
		System.out.println("签名验证的结果为: " + verify);

	}
}
