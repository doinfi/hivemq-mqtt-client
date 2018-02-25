package org.mqttbee.mqtt.message.auth.mqtt3;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.mqttbee.annotations.NotNull;
import org.mqttbee.api.mqtt.datatypes.MqttUTF8String;
import org.mqttbee.api.mqtt.mqtt3.message.auth.Mqtt3SimpleAuth;
import org.mqttbee.mqtt.datatypes.MqttUTF8StringImpl;
import org.mqttbee.mqtt.message.auth.MqttSimpleAuthImpl;

import java.nio.ByteBuffer;
import java.util.Optional;

/**
 * @author Silvio Giebl
 */
@Immutable
public class Mqtt3SimpleAuthView implements Mqtt3SimpleAuth {

    private final MqttSimpleAuthImpl simpleAuth;

    public Mqtt3SimpleAuthView(@NotNull final MqttSimpleAuthImpl simpleAuth) {
        this.simpleAuth = simpleAuth;
    }

    @NotNull
    @Override
    public MqttUTF8String getUsername() {
        final MqttUTF8StringImpl username = simpleAuth.getRawUsername();
        if (username == null) {
            throw new IllegalStateException();
        }
        return username;
    }

    @NotNull
    @Override
    public Optional<ByteBuffer> getPassword() {
        return simpleAuth.getPassword();
    }

}
