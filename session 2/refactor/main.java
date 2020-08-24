
public class UserRegistration {
  public List<PCRegistration> _pcRegistrations;
  public List<MacBookRegistration> _macBookRegistrations;
  public String _userName;

public UserRegistration (String userName)	{
		_userName = userName;
	};

	public UserRegistration ()	{};

	public void purchase(PCRegistration pcRegistration)	{
		_pcRegistrations.add(pcRegistration);
	};

	public void purchase(MacBookRegistration macRegistration)	{
		_macBookRegistrations.add(macRegistration);
	};

	public String receipt() {
		String receipt;
		for (pcRegistration in _pcRegistrations) {
			receipt += String.valueOf(pcRegistration.getPrice()) + ","
		}
		for (macBookRegistration price in _macBookRegistrations) {
			receipt += String.valueOf(macBookRegistration.getPrice()) + ","
		}
		return receipt.substring(0, receipt.length() - 1);
	};
}

public class PCRegistration {
  public String _name;
  public double _price;

  public PCRegistration (String name) {
		_name = name;
	};

	public PCRegistration () {};

	public String name() {
		return _name;
	}

	public String toString() {
		return _name;
	}

	public double getPrice() {
		return _price;
	}
}


public class MacBookRegistration {
  public String _name;
  public double _price;

  public MacBookRegistration(String name) {
		_name = name;
	}

	public MacBookRegistration() {};

	public String name()	{
		return _name;
	}

	public String toString() {
		return _name;
	}

	public double getPrice() {
		return _price;
	}
}