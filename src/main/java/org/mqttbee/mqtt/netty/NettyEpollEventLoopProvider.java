/*
 * Copyright 2018 The MQTT Bee project
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
 *
 */

package org.mqttbee.mqtt.netty;

import io.netty.channel.ChannelFactory;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.Executor;

/**
 * @author Silvio Giebl
 */
@Singleton
@ThreadSafe
class NettyEpollEventLoopProvider extends NettyEventLoopProvider {

    private static final ChannelFactory<EpollSocketChannel> CHANNEL_FACTORY = EpollSocketChannel::new;

    @Inject
    NettyEpollEventLoopProvider() {
    }

    @NotNull
    @Override
    MultithreadEventLoopGroup newEventLoopGroup(@Nullable final Executor executor, final int threadCount) {
        return new EpollEventLoopGroup(threadCount, executor);
    }

    @NotNull
    @Override
    public ChannelFactory<EpollSocketChannel> getChannelFactory() {
        return CHANNEL_FACTORY;
    }

}