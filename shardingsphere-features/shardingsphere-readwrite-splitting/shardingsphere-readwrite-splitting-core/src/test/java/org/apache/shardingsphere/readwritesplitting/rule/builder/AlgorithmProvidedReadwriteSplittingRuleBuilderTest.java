/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.readwritesplitting.rule.builder;

import org.apache.shardingsphere.infra.rule.builder.schema.DatabaseRuleBuilder;
import org.apache.shardingsphere.infra.rule.builder.schema.DatabaseRuleBuilderFactory;
import org.apache.shardingsphere.readwritesplitting.algorithm.config.AlgorithmProvidedReadwriteSplittingRuleConfiguration;
import org.apache.shardingsphere.readwritesplitting.api.rule.ReadwriteSplittingDataSourceRuleConfiguration;
import org.apache.shardingsphere.readwritesplitting.api.strategy.StaticReadwriteSplittingStrategyConfiguration;
import org.apache.shardingsphere.readwritesplitting.rule.ReadwriteSplittingRule;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public final class AlgorithmProvidedReadwriteSplittingRuleBuilderTest {
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Test
    public void assertBuild() {
        AlgorithmProvidedReadwriteSplittingRuleConfiguration ruleConfig = new AlgorithmProvidedReadwriteSplittingRuleConfiguration(
                Collections.singletonList(new ReadwriteSplittingDataSourceRuleConfiguration("name",
                        new StaticReadwriteSplittingStrategyConfiguration("writeDataSourceName", Arrays.asList("readDataSourceName")), null, "loadBalancerName")),
                Collections.emptyMap());
        DatabaseRuleBuilder builder = DatabaseRuleBuilderFactory.getInstanceMap(Collections.singletonList(ruleConfig)).get(ruleConfig);
        assertThat(builder.build(ruleConfig, "", Collections.emptyMap(), Collections.emptyList()), instanceOf(ReadwriteSplittingRule.class));
    }
}
