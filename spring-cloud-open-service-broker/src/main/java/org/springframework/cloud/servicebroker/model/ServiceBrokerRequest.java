/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.servicebroker.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Details common to all service broker requests.
 *
 * @author Scott Frederick
 */
@Getter
@ToString
@EqualsAndHashCode
public abstract class ServiceBrokerRequest {
	public final static String API_INFO_LOCATION_HEADER = "X-Api-Info-Location";
	public final static String ORIGINATING_IDENTITY_HEADER = "X-Broker-API-Originating-Identity";

	/**
	 * The ID used to identify the platform instance when the service broker is registered
	 * to multiple instances. Will be <code>null</code> if the service broker is not registered with an instance ID
	 * in the registered URL.
	 */
	@JsonIgnore
	protected transient String cfInstanceId;

	/**
	 * The API info endpoint of the platform instance making the call to the service broker.
	 */
	@JsonIgnore
	protected transient String apiInfoLocation;

	/**
	 * The identity of the of the user that initiated the request from the platform.
	 */
	@JsonIgnore
	protected transient Context originatingIdentity;


	public ServiceBrokerRequest() {
		this.cfInstanceId = null;
		this.apiInfoLocation = null;
		this.originatingIdentity = null;
	}
}