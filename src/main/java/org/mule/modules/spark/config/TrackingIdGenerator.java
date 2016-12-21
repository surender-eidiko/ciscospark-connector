package org.mule.modules.spark.config;

import java.util.UUID;

public class TrackingIdGenerator {
		public static String generateHexUUID() {
			String uuid = "";
			uuid = "ANYPOINT_"+UUID.randomUUID().toString();
			return uuid;
		}
		
}
