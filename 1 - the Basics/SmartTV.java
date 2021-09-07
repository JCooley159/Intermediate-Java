public class SmartTV {
	private String name;
	private int channel; // Default channel is 1
	private int volume; // Default volume level is 1
	boolean power; // By default TV is off
	private double price;

	public SmartTV() {
		this.name = "I do not know";
		this.channel = 1;
		this.volume = 1;
		this.power = false;
		this.price = 0.0;
	}

	public SmartTV(String name, double price) {
		this.name = name;
		this.channel = 1;
		this.volume = 1;
		this.power = false;
		this.price = price;
	}

	public SmartTV(String name, int channel, int volume, boolean power, double price) {
		this.name = name;
		this.channel = channel;
		this.volume = volume;
		this.power = power;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int newChannel) {
		if (power && newChannel >= 1 && newChannel <= 150)
			channel = newChannel;
	}

	public void turnOn() {
		this.power = true;
	}

	public void turnOff() {
		this.power = false;
	}

	public void channelUp() {
		if (power && channel < 150)
			channel++;
	}

	public void channelDown() {
		if (power && channel > 1)
			this.channel--;
	}

	public void volumeUp() {
		if (power && volume < 50)
			this.volume++;
	}

	public void volumeDown() {
		if (power && volume > 1) {
			this.volume--;
		}
	}

	@Override
	public String toString() {
		return "SmartTV [name=" + name + ", channel=" + channel + ", volume=" + volume + ", power=" + power + "]";
	}

}
