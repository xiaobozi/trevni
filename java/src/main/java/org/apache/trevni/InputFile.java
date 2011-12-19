/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.trevni;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/** A {@link FileInputStream} that implements {@link Input}. */
public class InputFile extends FileInputStream implements Input {

  public InputFile(File file) throws IOException { super(file); }

  @Override
  public long length() throws IOException { return getChannel().size(); }

  @Override
  public synchronized int read(long position, byte[] b, int start, int len)
    throws IOException {
    System.out.println("position = "+position+" start="+start+" len="+len+" b.len="+b.length);
    getChannel().position(position);
    return super.read(b, start, len);
  }

}

