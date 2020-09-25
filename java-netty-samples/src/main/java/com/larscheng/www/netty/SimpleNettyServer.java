package com.larscheng.www.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;
import lombok.val;

/**
 * @author Larscheng
 */
public class SimpleNettyServer {
    public static void main(String[] args) {
        // 创建BossGroup 和 WorkerGroup
        // BossGroup处理连接请求，正真的业务事件交给WorkerGroup处理
        // 两个工作组都是无限循环
        // NioEventLoopGroup默认的核心线程数为 cpu核数*2
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ChannelFuture future;

        try {
            // 创建服务端启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //工作组中创建用于处理连接的业务Handler
                            socketChannel.pipeline().addLast(new MyNettyServerHandler());
                        }
                    });

            System.out.println("[server]-> server is starting....");
            // 绑定一个端口并且同步生成一个channelFuture对象
            // 启动服务器
            future = bootstrap.bind(6565).sync();
            // 对关闭通道进行监听
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }


    /***
     * 自定义实现一个Handler
     * 自定义Handler需要继承 ChannelInboundHandlerAdapter
     */
    static class MyNettyServerHandler extends ChannelInboundHandlerAdapter {
        /**
         * 开始读取数据，可以读取客户端发送的消息
         *
         * @param ctx 上下文对象，含有管道pipeline，通道channel，地址信息等
         * @param msg 客户端发送的消息
         * @throws Exception
         */
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println("server read thread: " + Thread.currentThread().getName());
            System.out.println("server ctx: " + ctx);
            Channel channel = ctx.channel();
            ChannelPipeline pipeline = ctx.pipeline();
            // 将消息转换成ByteBuf，ByteBuf是netty封装的一个字节缓冲区，不是nio的
            ByteBuf buf = (ByteBuf) msg;
            System.out.println("server receive msg: " + buf.toString(CharsetUtil.UTF_8) + " from client[" + channel.remoteAddress() + "]");

        }

        /**
         * 数据读取完毕
         * 服务端读取完毕后，给客户端写入返回信息
         *
         * @param ctx 上下文
         * @throws Exception
         */
        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            // 将数据写入到缓存中，并刷新 writeAndFlush
            ctx.writeAndFlush(Unpooled.copiedBuffer("hello,client!", CharsetUtil.UTF_8));
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            ctx.close();
        }
    }
}
