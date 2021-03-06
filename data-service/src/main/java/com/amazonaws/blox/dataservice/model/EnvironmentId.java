/*
 * Copyright 2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may
 * not use this file except in compliance with the License. A copy of the
 * License is located at
 *
 *     http://aws.amazon.com/apache2.0/
 *
 * or in the "LICENSE" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.blox.dataservice.model;

import java.util.StringJoiner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
// required for builder
@AllArgsConstructor
// required for mapstruct
@NoArgsConstructor
public class EnvironmentId {

  private static final String DELIMITER = "/";

  @NonNull private String environmentName;
  @NonNull private String accountId;
  @NonNull private String cluster;

  public String generateAccountIdCluster() {
    return new StringJoiner(DELIMITER).add(accountId).add(cluster).toString();
  }

  public String generateAccountIdClusterEnvironmentName() {
    return new StringJoiner(DELIMITER).add(accountId).add(cluster).add(environmentName).toString();
  }

  public static String getAccountIdFromAccountIdCluster(String accountIdCluster) {
    return accountIdCluster.split(DELIMITER)[0];
  }

  public static String getClusterFromAccountIdCluster(String accountIdCluster) {
    return accountIdCluster.split(DELIMITER, 2)[1];
  }

  public static String getAccountIdFromAccountIdClusterEnvironmentName(
      String accountIdClusterEnvironmentName) {
    return accountIdClusterEnvironmentName.split(DELIMITER)[0];
  }
}
