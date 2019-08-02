/*
 * Copyright 2018 The Feast Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package feast.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Feature stream topic created by feast
 */
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="topics")
public class FeatureStreamTopic extends AbstractTimestampEntity {

  @Id
  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "entity", unique = true)
  private EntityInfo entity;

  public FeatureStreamTopic() {
    super();
  }
}
