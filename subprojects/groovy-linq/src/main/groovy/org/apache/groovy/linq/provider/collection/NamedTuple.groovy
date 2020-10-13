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
 * Immutable named list to represent list result of GINQ
 *
 * @since 4.0.0
 */
@CompileStatic
class NamedTuple<E> extends Tuple<E> {
    private final List<String> nameList

    NamedTuple(List<E> elementList, List<String> nameList) {
        super(elementList as E[])
        this.nameList = nameList
    }

    def getAt(String name) {
        final int index = nameList.indexOf(name)

        if (-1 == index) {
            throw new IndexOutOfBoundsException("Failed to find element with name: $name")
        }

        return get(index)
    }

    def get(String name) {
        return getAt(name)
    }

    List<String> getNameList() {
        return Collections.unmodifiableList(nameList)
    }

    @Override
    String toString() {
        '(' + nameList.withIndex()
                .collect((String n, int i) -> { "${n}:${this[i]}" })
                .join(', ') + ')'
    }
}
