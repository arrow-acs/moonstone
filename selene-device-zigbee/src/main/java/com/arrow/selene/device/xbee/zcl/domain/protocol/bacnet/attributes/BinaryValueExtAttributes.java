package com.arrow.selene.device.xbee.zcl.domain.protocol.bacnet.attributes;

public interface BinaryValueExtAttributes {
    short ACKED_TRANSACTIONS_ATTRIBUTE_ID = 0x0000;
    short ALARM_VALUE_ATTRIBUTE_ID = 0x0006;
    short NOTIFICATION_CLASS_ATTRIBUTE_ID = 0x0011;
    short EVENT_ENABLE_ATTRIBUTE_ID = 0x0023;
    short EVENT_STATE_ATTRIBUTE_ID = 0x0024;
    short NOTIFY_TYPE_ATTRIBUTE_ID = 0x0048;
    short TIME_DELAY_ATTRIBUTE_ID = 0x0071;
    short EVENT_TIMESTAMPTS_ATTRIBUTE_ID = 0x0082;
}
