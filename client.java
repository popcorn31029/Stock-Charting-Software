package socket;

import java.net.*;
import java.util.Scanner;
import java.io.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class client {
	@FXML
	Label _text1;
	@FXML
	Label _text2;
	@FXML
	Label _text3;
	@FXML
	Label _text4;
	@FXML
	Label _text5;
	@FXML
	Label _text6;
	@FXML
	Label _text7;
	@FXML
	Label _text8;
	@FXML
	Label _text9;
	@FXML
	Label _text10;
	@FXML
	Label _text11;
	@FXML
	Label _text12;
	@FXML
	Label _text13;
	@FXML
	Label _text14;
	@FXML
	Label _text15;
	@FXML
	Label _text16;
	@FXML
	Label _text17;
	@FXML
	Label _text18;
	@FXML
	Label _text19;
	@FXML
	Label _text20;
	@FXML
	TextField _textfc;
	@FXML
	TextField _texttc;
	@FXML
	Button _btn2330;
	@FXML
	Button _btn2317;
	@FXML
	Button _btn2454;
	@FXML
	Button _btn6505;
	@FXML
	Button _btn2412;
	@FXML
	Button _btn2308;
	@FXML
	Button _btn1;
	@FXML
	Button _btn2;
	@FXML
	Button _btn3;
	@FXML
	Button _btn4;
	OutputStream output;
	PrintWriter writer;
	InputStream input;
	BufferedReader reader;
	String[] data;
	int a = 1;
	public client() {
		Scanner in = new Scanner(System.in);
		String serverName = "127.0.0.1";
		int serverPort = 12000;
		SocketAddress socketAddress = new InetSocketAddress(serverName, serverPort);
		Socket socket = new Socket();
		try {
			socket.connect(socketAddress);
			System.out.print("Hello, I am client ");
			
			// send
			output = socket.getOutputStream();
			writer = new PrintWriter(output, true);
			// get
			input = socket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(input));
			System.out.println(reader.readLine() + "!");
		} catch (SocketException e) {
			System.out.println("disconnected");
		} catch (IOException e) {
			System.out.println("Server exception: " + e.getMessage());
		}
		in.close();
	}
	@FXML
	public void pressed2330(ActionEvent e) throws IOException
	{
		writer.println("2330");
		data = reader.readLine().split("a");
		update();
		
	}
	public void pressed23301(MouseEvent e) throws IOException
	{
		_btn2330.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed23302(MouseEvent e) throws IOException
	{
		_btn2330.setStyle("-fx-background-color: gray;");
	}
	public void pressed2317(ActionEvent e) throws IOException
	{
		writer.println("2317");
		data = reader.readLine().split("a");
		update();
	}
	public void pressed23171(MouseEvent e) throws IOException
	{
		_btn2317.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed23172(MouseEvent e) throws IOException
	{
		_btn2317.setStyle("-fx-background-color: gray;");
	}
	public void pressed2454(ActionEvent e) throws IOException
	{
		writer.println("2454");
		data = reader.readLine().split("a");
		update();
	}
	public void pressed24541(MouseEvent e) throws IOException
	{
		_btn2454.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed24542(MouseEvent e) throws IOException
	{
		_btn2454.setStyle("-fx-background-color: gray;");
	}
	public void pressed6505(ActionEvent e) throws IOException
	{
		writer.println("6505");
		data = reader.readLine().split("a");
		update();
	}
	public void pressed65051(MouseEvent e) throws IOException
	{
		_btn6505.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed65052(MouseEvent e) throws IOException
	{
		_btn6505.setStyle("-fx-background-color: gray;");
	}
	public void pressed2412(ActionEvent e) throws IOException
	{
		writer.println("2412");
		data = reader.readLine().split("a");
		update();
	}
	public void pressed24121(MouseEvent e) throws IOException
	{
		_btn2412.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed24122(MouseEvent e) throws IOException
	{
		_btn2412.setStyle("-fx-background-color: gray;");
	}
	public void pressed2308(ActionEvent e) throws IOException
	{
		writer.println("2308");
		data = reader.readLine().split("a");
		update();
	}
	public void pressed23081(MouseEvent e) throws IOException
	{
		_btn2308.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed23082(MouseEvent e) throws IOException
	{
		_btn2308.setStyle("-fx-background-color: gray;");
	}
	public void pressed1(ActionEvent e) throws IOException
	{
		writer.println("1");
		String s = _textfc.getText();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)<'0' || s.charAt(i)>'9')
			{
				s = "0";
			}
		}
		writer.println(s);
		_texttc.setText(reader.readLine());
	}
	public void pressed11(MouseEvent e) throws IOException
	{
		_btn1.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed12(MouseEvent e) throws IOException
	{
		_btn1.setStyle("-fx-background-color: gray;");
	}
	public void pressed2(ActionEvent e) throws IOException
	{
		writer.println("2");
		String s = _textfc.getText();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)<'0' || s.charAt(i)>'9')
			{
				s = "0";
			}
		}
		writer.println(s);
		_texttc.setText(reader.readLine());
	}
	public void pressed21(MouseEvent e) throws IOException
	{
		_btn2.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed22(MouseEvent e) throws IOException
	{
		_btn2.setStyle("-fx-background-color: gray;");
	}
	public void pressed3(ActionEvent e) throws IOException
	{
		writer.println("3");
		String s = _textfc.getText();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)<'0' || s.charAt(i)>'9')
			{
				s = "0";
			}
		}
		writer.println(s);
		_texttc.setText(reader.readLine());
	}
	public void pressed31(MouseEvent e) throws IOException
	{
		_btn3.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed32(MouseEvent e) throws IOException
	{
		_btn3.setStyle("-fx-background-color: gray;");
	}
	public void pressed4(ActionEvent e) throws IOException
	{
		writer.println("4");
		String s = _textfc.getText();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)<'0' || s.charAt(i)>'9')
			{
				s = "0";
			}
		}
		writer.println(s);
		_texttc.setText(reader.readLine());
	}
	public void pressed41(MouseEvent e) throws IOException
	{
		_btn4.setStyle("-fx-background-color: #f5d376;");
	}
	public void pressed42(MouseEvent e) throws IOException
	{
		_btn4.setStyle("-fx-background-color: gray;");
	}
	public void update()
	{
		_text1.setText(data[0]);
		_text2.setText(data[4]);
		_text3.setText(data[8]);
		_text4.setText(data[12]);
		_text5.setText(data[16]);
		_text6.setText(data[1]);
		_text7.setText(data[5]);
		_text8.setText(data[9]);
		_text9.setText(data[13]);
		_text10.setText(data[17]);
		_text11.setText(data[2]);
		_text12.setText(data[6]);
		_text13.setText(data[10]);
		_text14.setText(data[14]);
		_text15.setText(data[18]);
		_text16.setText(data[3]);
		_text17.setText(data[7]);
		_text18.setText(data[11]);
		_text19.setText(data[15]);
		_text20.setText(data[19]);
	}
}