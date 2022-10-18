# mobiletest

## How has the development been of CustomCard?

It has been made as a separate module thinking that it will be completely decoupled from any app

A CustomCard component has been developed allows configuration by XML parameters such as:

Set to CustomCard component in XML layout using diferents attributes:
* "coinType": Select the type of modena that the amounts will have "EURO", "DOLAR" and "LIBRA by default the euro is selected" 
* "showCardControl": Show constraintLayout that contains Card Control
* "showMoreOptions": Show ImageView more Options
* "showImagenCard":Show constraintLayout more that contains Card 
* "showLastNumberCard": Show the las number of card in header
* "cardActive": Show constraintLayout wiht SwitchCompat

by default all boolean attributes are true

~~~
<com.mobile.customcard.CustomCard
        android:id="@+id/customCard"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:showCardControl="true"
        app:showLastNumberCard="true"
        app:showMoreOptions="true"
        app:showImagenCard="true"
        app:coinType="Dolar"
        app:cardActive="true"/>
~~~

For code also set config to CustomCard 

Init view component config:
* setData  with this functions you can set the information of card
* setConfig with this functions you can define Font and Color that CustomCard Use
  * FontConfig It allows set value for titles and other text
  * ColorConfig allows set value for TextTitle, Text Card Control, and  progress bar color
* build this function init the CustomCard component

~~~
 binding.apply {
                customCard
                    .setConfig(
                        CustomCardConfig(
                            colors = ColorConfig(), // or se the colors to use
                            fonts = FontConfig(
                                titles = <font-family to use>"
                                )
                            )
                        )
                    )
                    .setData(
                        CustomCardData(
                          //Set the values of card

                        )
                    )
                    .build()
~~~
## Accessibility of Custom Card
When the talkBack is activated the Custom Card elements will be described by blocks

5 blocks have been defined

* Header block where the type of card is indicated, the last digits and the type of ownership of the displayed card

* Credit limit block where the credit limit is indicated

* Economic block where the amount disposed and the amount available are indicated

* Block to activate or deactivate the card, the status of the card is indicated and the user is also told that he can perform an action

* Card control block, the user is informed of the card control action


## Accessibility of app List Custom Card
When the talkBack is activated the app List CardAt the list level, it is indicated that a list of cards is being displayed and the last 4 digits of the card that is on the screen are indicated, in addition, it is indicated to slide to the right to know more information about the card.At the list level, it is indicated that a list of cards is being displayed and the last 4 digits of the card that is on the screen are indicated, in addition, it is indicated to slide to the right to know more information about the card.


## How has the development been of List of Card App?
* The card list application has been developed, using a package structure that would simulate a layered architecture based on a clean architecture.

* In this case we have the data layer, domain layer and presentation layer.

* Hilt has been used for injection dependencies

* The data source does not come from any service.

* No tests of any kind have been carried out.

* For the example of the use of the customCard, the font monserrat is defined


## User manual
To implement the CustomCard package, add the module access implementation to the gradle where you need to use it.

## Short Video


https://user-images.githubusercontent.com/11575107/196488208-47227034-e795-4615-8f9e-7e15bbf9add0.mp4

