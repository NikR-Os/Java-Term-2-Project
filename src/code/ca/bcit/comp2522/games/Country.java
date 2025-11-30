package ca.bcit.comp2522.games;

public class Country
{
    private final String name;
    private final String capitalCityName;
    private final String[] facts;

    public Country(final String name, final String capitalCityName,
                   final String factA, final String factB, final String factC)
    {
        this.name = name;
        this.capitalCityName = capitalCityName;
        this.facts = new String[] {factA, factB, factC};
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
