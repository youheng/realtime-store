/*
 * Copyright 2012 Goodow.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.goodow.realtime.store.impl;

import com.goodow.realtime.json.JsonObject;
import com.goodow.realtime.store.EventType;
import com.goodow.realtime.store.TextDeletedEvent;

class TextDeletedEventImpl extends BaseModelEventImpl implements TextDeletedEvent {
  /**
   * The index of the first character that was deleted.
   */
  public final int index;
  /**
   * The deleted text.
   */
  public final String text;

  /**
   * @param serialized The serialized event object.
   */
  public TextDeletedEventImpl(JsonObject serialized) {
    super(serialized.set("type", EventType.TEXT_DELETED.name()).set("bubbles", false));
    this.index = (int) serialized.getNumber("index");
    this.text = serialized.getString("text");
  }

  @Override public int index() {
    return index;
  }

  @Override public String text() {
    return text;
  }
}
