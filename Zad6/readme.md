# Lab6

#### Wykorzałem Github Actions do testowania podczas mergów branchy.
#### Github Actions wykorzystuje plik .yml, który odpala kod z commita w środowisku testowym i go testuje.
#### Widać, że poprawny kod, który przechodzi testy można bez problemu zmergować z mainem.
#### Natomiast jeżeli wprowadzimy zmiany w kodzie, które nie przejdą testów, wtedy nie będzie można zmergować brancha.

## Poprawny merge:
![correct](https://user-images.githubusercontent.com/76203418/233182252-1f185723-6556-4b3a-ae55-ca9d068141b4.jpg)
## Niepoprawny merge:
![fail](https://user-images.githubusercontent.com/76203418/233182267-633861f4-40c4-4adc-a171-6fb0f6f410ae.jpg)
