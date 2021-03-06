/**
 * Copyright (c) 2013-2019 Contributors to the Eclipse Foundation
 *
 * <p> See the NOTICE file distributed with this work for additional information regarding copyright
 * ownership. All rights reserved. This program and the accompanying materials are made available
 * under the terms of the Apache License, Version 2.0 which accompanies this distribution and is
 * available at http://www.apache.org/licenses/LICENSE-2.0.txt
 */
package org.locationtech.geowave.core.store.api;

import org.locationtech.geowave.core.store.adapter.statistics.StatisticsType;

/**
 * The statistics represents an aggregation on the ingested entries that has been pre-computed and
 * implicitly maintained. It wraps the actual result with identifiers to understand where the result
 * came from and what it represents.
 *
 * @param <R> the result type
 */
public interface Statistics<R> {
  /**
   * the result of the statistics
   *
   * @return the result
   */
  R getResult();

  /**
   * The type of the statistics
   *
   * @return the type
   */
  StatisticsType<R, ?> getType();

  /**
   * sometimes there are more than one stat per statistical type per data type and in these cases,
   * this additional identifier is used for uniqueness for example some statistics are per field
   * (within the data type) or per index so this identifier would be the field name or index name in
   * those cases
   *
   * @return the extended String for this statistics to make it uniquely identifiable
   */
  String getExtendedId();

  /**
   * the data type name
   *
   * @return the name of the data type
   */
  String getDataTypeName();
}
