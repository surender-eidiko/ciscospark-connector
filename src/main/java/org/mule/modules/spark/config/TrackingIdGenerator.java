package org.mule.modules.spark.config;

import java.util.UUID;

public class TrackingIdGenerator {
	
		private static String uuid = "ANYPOINT_";
		public static String generateHexUUID() {
			uuid+= UUID.randomUUID().toString();
			return uuid;
		}
		
}
