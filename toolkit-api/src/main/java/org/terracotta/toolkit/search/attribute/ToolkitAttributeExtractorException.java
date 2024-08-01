/*
 * Copyright Terracotta, Inc.
 * Copyright Super iPaaS Integration LLC, an IBM Company 2024
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
package org.terracotta.toolkit.search.attribute;

import org.terracotta.toolkit.search.SearchException;

import java.io.Serializable;

public class ToolkitAttributeExtractorException extends SearchException implements Serializable {
  private static final long serialVersionUID = 8924836209375321094L;

  public ToolkitAttributeExtractorException(Throwable cause) {
    super(cause);
  }

  public ToolkitAttributeExtractorException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public ToolkitAttributeExtractorException(String msg) {
    super(msg);
  }

}
