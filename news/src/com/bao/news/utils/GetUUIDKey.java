package com.bao.news.utils;

import java.net.InetAddress;
import java.security.SecureRandom;
import java.util.Date;

public class GetUUIDKey {
private static SecureRandom seederStatic;
	
	private static String midValueStatic = null;
	private static byte addr[];
	private static byte addrBytes[] = null;
	
	static {
		seederStatic = null;
		addr = null;
		try {
			addr = InetAddress.getLocalHost().getAddress();
			addrBytes = InetAddress.getLocalHost().getAddress();
			StringBuffer buffer = new StringBuffer(8);
			buffer.append(toHex(toInt(addr), 8));
			midValueStatic = buffer.toString();
			seederStatic = new SecureRandom();
			seederStatic.nextInt();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static String getUUID(){
		return generate(new Date());
	}
	
	public static String generate(Object obj) {
		StringBuffer uid = new StringBuffer(32);
		long currentTimeMillis = System.currentTimeMillis();
		uid.append(toHex((int) (currentTimeMillis & -1L), 8));
		uid.append(midValueStatic);
		uid.append(toHex(System.identityHashCode(obj), 8));
		uid.append(toHex(getRandom(), 8));
		return uid.toString();
	}

	private static synchronized int getRandom() {
		return seederStatic.nextInt();
	}
	
	private static String toHex(int value, int length) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		StringBuffer buffer = new StringBuffer(length);
		int shift = length - 1 << 2;
		for (int i = -1; ++i < length;) {
			buffer.append(hexDigits[value >> shift & 0xf]);
			value <<= 4;
		}

		return buffer.toString();
	}
	
	private static int toInt(byte bytes[]) {
		int value = 0;
		for (int i = -1; ++i < bytes.length;) {
			value <<= 8;
			value |= bytes[i];
		}

		return value;
	}
}
