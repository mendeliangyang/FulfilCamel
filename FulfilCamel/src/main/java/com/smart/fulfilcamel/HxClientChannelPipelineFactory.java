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
import org.apache.camel.component.netty4.ClientInitializerFactory;
import org.apache.camel.component.netty4.NettyProducer;
import org.apache.camel.component.netty4.handlers.ClientChannelHandler;

/**
 *
 * @author Administrator
 */
public class HxClientChannelPipelineFactory extends ClientInitializerFactory {

    private final int maxLineSize = 1024;
public HxClientChannelPipelineFactory(){}
    public HxClientChannelPipelineFactory(NettyProducer np) {
        this.producer = np;
    }

    private NettyProducer producer;

    @Override
    public ClientInitializerFactory createPipelineFactory(NettyProducer np) {
        return new HxClientChannelPipelineFactory(np);
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        
        ChannelPipeline channelPipeline = ch.pipeline();
        channelPipeline.addLast("encoder-SD", new StringEncoder(CharsetUtil.US_ASCII));
        channelPipeline.addLast("decoder-DELIM", new DelimiterBasedFrameDecoder(maxLineSize, true, Delimiters.lineDelimiter()));
        channelPipeline.addLast("decoder-SD", new StringDecoder(CharsetUtil.US_ASCII));
        channelPipeline.addLast("handler", new ClientChannelHandler(producer));
    }

}
