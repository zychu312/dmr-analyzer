### DMR Analyzer

CLI Application which expects as a first argument path to .csv file which describes DMR in following schema:

>  X Y Z id

and uses space as a separator.

The second argument is number of divisions e.g. if user will pass 4 then stats will be calculated on following levels:
- 25%
- 50%
- 75%

of DMR height (there is assumption made that Y axis responds to DMR height )

As an results program produces .csv file in the same folder as input one.
> id AreaOn1Lvl AreaOn2Lvl AreaOn3Lvl ...


### Requirements:
- Java 11
### Development
- Project based on Gradle with Jar task defined