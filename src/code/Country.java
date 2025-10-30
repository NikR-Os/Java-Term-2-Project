public class Country
{
    private final String name;
    private final String capitalCityName;
    private final String facts[];

    public Country(final String name, final String capitalCityName)
    {
        this.name = name;
        this.capitalCityName = capitalCityName;
        this.facts = new String[3];
    }

    public String getName()
    {
        return name;
    }

    public String getCapitalCityName()
    {
        return capitalCityName;
    }

    public String[] getFacts()
    {
        return facts;
    }
}
