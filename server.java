package socket;

import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

class ServerThread extends Thread {
	
	public String infoString(String num) {
		int j = 0;
		String s = "";
		try {
	        Document doc = Jsoup.connect("https://goodinfo.tw/StockInfo/ShowBuySaleChart.asp?STOCK_ID=" + num + "&CHT_CAT=DATE").get();
	        Elements element = doc.getElementsByTag("table");
	        for (Element ele : element)
	        {
	        	String[] info = ele.getElementsByTag("td").text().split(" "); 
	        	if(j==24)
	        	{
	        		System.out.println(ele.getElementsByTag("td").text());
	        		for(int k=39;k<128;k=k+19)
	        		{
	        			s += info[k] + "a" + info[k+10] + "a" + info[k+11] + "a" + info[k+12] + "a";
	        		}
	        		System.out.println(s);
	        	}
	        	j++;
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return s;
	}
	String s2330 = "";
	String s2317 = "";
	String s2454 = "";
	String s6505 = "";
	String s2412 = "";
	String s2308 = "";
	public void initial()
	{
		s2330 = infoString("2330");
		s2317 = infoString("2317");
		s2454 = infoString("2454");
		s6505 = infoString("6505");
		s2412 = infoString("2412");
		s2308 = infoString("2308");
	}

	double fc_1 = 28.20;
	double fc_2 = 4.35;
	double fc_3 = 34.82;
	double fc_4 = 38.56;
	int tc = 0;
	int ma = 99999999;
	int a;
	private Socket socket;
	public ServerThread(Socket socket, int a) {
		this.socket = socket;
		this.a = a;
		initial();
	}
	
	
	
	public void run() {
		try {
			// get
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			// send
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			writer.println(a);
			String text;
			do {
				text = reader.readLine();
				if (text != null) {
					System.out.println(text);
					switch (text) {
					case "2330":
						writer.println(s2330);
						break;
					case "2317":
						writer.println(s2317);
						break;
					case "2454":
						writer.println(s2454);
						break;
					case "6505":
						writer.println(s6505);
						break;
					case "2412":
						writer.println(s2412);
						break;
					case "2308":
						writer.println(s2308);
						break;
					case "1":
						tc = (int) (fc_1 * Double.valueOf(reader.readLine()));
						writer.println(Math.min(tc, ma));
						break;
					case "2":
						tc = (int) (fc_2 * Double.valueOf(reader.readLine()));
						writer.println(Math.min(tc, ma));
						break;
					case "3":
						tc = (int) (fc_3 * Double.valueOf(reader.readLine()));
						writer.println(Math.min(tc, ma));
						break;
					case "4":
						tc = (int) (fc_4 * Double.valueOf(reader.readLine()));
						writer.println(Math.min(tc, ma));
						break;
					}
					if (text.equals("bye"))
						break;
				}
			} while (true);
			System.out.println("client disconnect");
			socket.close();
		} catch (SocketException e) {
			System.out.println("client " + a + " disconnected");
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("client " + a + " disconnected");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("client " + a + " disconnected");
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("Server exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}

public class server {
	public static void main(String[] args) {
		String serverName = "127.0.0.1";
		int serverPort = 12000;
		int a = 1;
		SocketAddress socketAddress = new InetSocketAddress(serverName, serverPort);
		//
		try (ServerSocket serverSocket = new ServerSocket()) {
			//
			serverSocket.bind(socketAddress);
			System.out.println("Multithreading server binding success");
			//
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("client " + a + " connected");
				Thread thread = new Thread(new ServerThread(socket, a));
				thread.start();
				a++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Server shutdown");
		}
	}
}