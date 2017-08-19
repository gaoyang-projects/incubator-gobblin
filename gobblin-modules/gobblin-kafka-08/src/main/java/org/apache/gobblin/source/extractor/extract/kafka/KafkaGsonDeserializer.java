/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.gobblin.source.extractor.extract.kafka;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;
import com.google.gson.JsonElement;


/**
 * Implementation of {@link Deserializer} that deserializes Kafka data into a {@link JsonElement} using the
 * {@link StandardCharsets#UTF_8} encoding.
 */
public class KafkaGsonDeserializer implements Deserializer<JsonElement> {

  private static final Gson GSON = new Gson();

  @VisibleForTesting
  static final Charset CHARSET = StandardCharsets.UTF_8;

  @Override
  public void configure(Map<String, ?> configs, boolean isKey) {
    // Do nothing
  }

  @Override
  public JsonElement deserialize(String topic, byte[] data) {
    return GSON.fromJson(new String(data, CHARSET), JsonElement.class);
  }

  @Override
  public void close() {
    // Do nothing
  }
}