package com.microservice.protocol.netty;



import com.microservice.framework.Invocation;
import com.microservice.framework.Protocol;
import com.microservice.framework.URL;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class NettyProtocol implements Protocol {
	 @Override
	public void start(URL url) {
		NettyServer server = new NettyServer();
		server.start(url.getHostName(), url.getPort());
	}

	@Override
	public String post(URL url, final Invocation invocation) {
		Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup worker = new NioEventLoopGroup();
        try{
            bootstrap.group(worker);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.handler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast(new ObjectEncoder());
                    ch.pipeline().addLast(new ObjectDecoder(Integer.MAX_VALUE,
                            ClassResolvers.cacheDisabled(null)));
                    ch.pipeline().addLast(new NettyClientHandler(invocation));
                }
            });
            ChannelFuture channelFuture = bootstrap.connect(url.getHostName(), url.getPort()).sync();
            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            worker.shutdownGracefully();
        }
		return null;
	}

}
