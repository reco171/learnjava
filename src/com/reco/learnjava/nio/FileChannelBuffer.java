package com.reco.learnjava.nio;
/**
 * 数据是从通道读入缓冲区，从缓冲区写入到通道中的。Java NIO的通道类似流,不同点是双向的
 * Java NIO:
 *  NIO 是一种同步非阻塞的 IO 模型。同步是指线程不断轮询 IO 事件是否就绪，非阻塞是指线程在等待 IO 的时候，
 *  可以同时做其他任务。同步的核心就是 Selector，Selector 代替了线程本身轮询 IO 事件，
 *  避免了阻塞同时减少了不必要的线程消耗；非阻塞的核心就是通道和缓冲区，
 *  当 IO 事件就绪时，可以通过写道缓冲区，保证 IO 的成功，而无需线程阻塞式地等待。https://www.cnblogs.com/geason/p/5774096.html
 *  Mina:
 *  通过Java nio技术基于TCP/IP和UDP/IP协议提供了抽象的、事件驱动的、异步的API
 */
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelBuffer {

	public static void main(String[] args) throws IOException {
		RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			buf.flip();//将缓存字节数组的指针设置为数组的开始序列即数组下标0
			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
	}
}
