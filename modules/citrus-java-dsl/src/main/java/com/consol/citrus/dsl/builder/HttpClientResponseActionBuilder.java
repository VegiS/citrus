/*
 * Copyright 2006-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.consol.citrus.dsl.builder;

import com.consol.citrus.TestAction;
import com.consol.citrus.actions.ReceiveMessageAction;
import com.consol.citrus.dsl.actions.DelegatingTestAction;
import com.consol.citrus.endpoint.Endpoint;
import com.consol.citrus.http.message.HttpMessage;
import com.consol.citrus.message.MessageType;
import org.springframework.http.HttpStatus;

/**
 * @author Christoph Deppisch
 * @since 2.4
 */
public class HttpClientResponseActionBuilder extends ReceiveMessageBuilder<ReceiveMessageAction, HttpClientResponseActionBuilder> {

    /** Http message to send or receive */
    private HttpMessage httpMessage = new HttpMessage();

    /**
     * Default constructor using http client endpoint.
     * @param delegate
     * @param httpClient
     */
    public HttpClientResponseActionBuilder(DelegatingTestAction<TestAction> delegate, Endpoint httpClient) {
        super();
        getAction().setEndpoint(httpClient);
        message(httpMessage);
        messageType(MessageType.XML);
        delegate.setDelegate(action);
    }

    /**
     * Default constructor using http client uri.
     * @param delegate
     * @param httpClientUri
     */
    public HttpClientResponseActionBuilder(DelegatingTestAction<TestAction> delegate, String httpClientUri) {
        super();
        getAction().setEndpointUri(httpClientUri);
        message(httpMessage);
        messageType(MessageType.XML);
        delegate.setDelegate(action);
    }

    @Override
    protected void setPayload(String payload) {
        httpMessage.setPayload(payload);
    }

    /**
     * Sets the response status.
     * @param status
     * @return
     */
    public HttpClientResponseActionBuilder status(HttpStatus status) {
        httpMessage.status(status);
        return this;
    }

    /**
     * Sets the response status code.
     * @param statusCode
     * @return
     */
    public HttpClientResponseActionBuilder statusCode(Integer statusCode) {
        httpMessage.statusCode(statusCode);
        return this;
    }

    /**
     * Sets the response reason phrase.
     * @param reasonPhrase
     * @return
     */
    public HttpClientResponseActionBuilder reasonPhrase(String reasonPhrase) {
        httpMessage.reasonPhrase(reasonPhrase);
        return this;
    }

    /**
     * Sets the http version.
     * @param version
     * @return
     */
    public HttpClientResponseActionBuilder version(String version) {
        httpMessage.version(version);
        return this;
    }

    /**
     * Sets the request content type header.
     * @param contentType
     * @return
     */
    public HttpClientResponseActionBuilder contentType(String contentType) {
        httpMessage.contentType(contentType);
        return this;
    }
}
