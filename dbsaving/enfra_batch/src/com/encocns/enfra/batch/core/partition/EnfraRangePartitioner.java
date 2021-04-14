/*
 * Copyright EncoCNS.,LTD.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of EncoCNS.,LTD. ("Confidential Information").
 */
/**
 * @file EnfraRangePartitioner.java
 * @brief 
 */
/**
 * @namespace com.encocns.cfw.database
 * @brief 
 */
package com.encocns.enfra.batch.core.partition;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class EnfraRangePartitioner implements Partitioner {

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		Map<String, ExecutionContext> result = new HashMap<String, ExecutionContext>();

		for (int i = 1; i <= gridSize; i++) {
			ExecutionContext value = new ExecutionContext();
			
			value.putString("partition", String.valueOf(i));
			
			//spring fixed key
			result.put("partition" + i, value);
		}

		return result;
	}

}
