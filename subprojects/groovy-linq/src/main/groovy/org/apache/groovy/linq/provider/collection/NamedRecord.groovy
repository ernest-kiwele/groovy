/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.groovy.linq.provider.collection


import groovy.transform.CompileStatic

/**
 * Represents named record
 *
 * @since 4.0.0
 */
@CompileStatic
class NamedRecord<E, T> extends NamedTuple<E> {
    private T sourceRecord

    NamedRecord(List<E> elementList, List<String> nameList) {
        super(elementList, nameList)
    }

    @Override
    def getAt(String name) {
        if (name in nameList) return super.getAt(name)

        return sourceRecord
    }

    @Override
    def get(String name) {
        if (name in nameList) return super.getAt(name)

        return sourceRecord
    }

    T sourceRecord() {
        return sourceRecord
    }

    NamedRecord<E, T> sourceRecord(T sourceRecord) {
        this.sourceRecord = sourceRecord
        return this
    }
}
