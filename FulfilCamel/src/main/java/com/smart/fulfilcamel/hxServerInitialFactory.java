/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.fulfilcamel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.apache.camel.component.netty4.NettyConsumer;
import org.apache.camel.component.netty4.ServerInitializerFactory;
import org.apache.camel.component.netty4.handlers.ServerChannelHandler;

/**
 *
 * @author Administrator
 */
public class hxServerInitialFactory extends ServerInitializerFactory {

    private final int maxLineSize = 1024;
    private NettyConsumer consumer;

    public hxServerInitialFactory() {
    }

    public hxServerInitialFactory(NettyConsumer nc) {
        this.consumer = nc;

    }

    @Override
    public ServerInitializerFactory createPipelineFactory(NettyConsumer nc) {

        return new hxServerInitialFactory(nc);
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast("encoder-SD", new StringEncoder(CharsetUtil.UTF_8));
        channelPipeline.addLast("decoder-DELIM", new DelimiterBasedFrameDecoder(maxLineSize, true, Delimiters.lineDelimiter()));
        channelPipeline.addLast("decoder-SD", new StringDecoder(CharsetUtil.UTF_8));
        // here we add the default Camel ServerChannelHandler for the consumer, to allow Camel to route the message etc.
        channelPipeline.addLast("handler", new ServerChannelHandler(consumer));
    }

}
