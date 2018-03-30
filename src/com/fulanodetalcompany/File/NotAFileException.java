/*
 * Copyright 2018 Roberto Alonso De la Garza Mendoza.
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
package com.fulanodetalcompany.File;

/**
 * This exception jump when an instance of <strong>IO.File</strong> is not
 * a file
 * @author Roberto Alonso De la Garza Mendoza
 */
public class NotAFileException extends Exception {

    /**
     * Creates a new instance of <code>NotAFileException</code> without detail
     * message.
     */
    public NotAFileException() {
    }

    /**
     * Constructs an instance of <code>NotAFileException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotAFileException(String msg) {
        super(msg);
    }
}
