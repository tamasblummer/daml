// Copyright (c) 2019 Digital Asset (Switzerland) GmbH and/or its affiliates. All rights reserved.
// SPDX-License-Identifier: Apache-2.0

package com.digitalasset;

import com.daml.ledger.javaapi.data.Record;
import com.digitalasset.ledger.api.v1.ValueOuterClass;
import org.junit.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import tests.maptest.MapRecord;

@RunWith(JUnitPlatform.class)
public class MapTest {

    @Test
    public void mapRecordRoundTrip() {

        ValueOuterClass.Record protoRecord = ValueOuterClass.Record.newBuilder()
                .addFields(ValueOuterClass.RecordField.newBuilder()
                        .setLabel("mapField")
                        .setValue(ValueOuterClass.Value.newBuilder()
                                .setMap(ValueOuterClass.Map.newBuilder()
                                        .addEntries(ValueOuterClass.Map.Entry.newBuilder()
                                                .setKey(ValueOuterClass.Value.newBuilder().setText("key1"))
                                                .setValue(ValueOuterClass.Value.newBuilder().setText("value1"))
                                                .build())
                                        .addEntries(ValueOuterClass.Map.Entry.newBuilder()
                                                .setKey(ValueOuterClass.Value.newBuilder().setText("key2"))
                                                .setValue(ValueOuterClass.Value.newBuilder().setText("value2"))
                                                .build()
                                        )
                                        .build())
                                .build())
                        .build())
                .build();

        Record dataRecord = Record.fromProto(protoRecord);
        MapRecord fromValue = MapRecord.fromValue(dataRecord);
        // TO BE COMPLETED
    }

}