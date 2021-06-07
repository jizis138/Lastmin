package ru.vsibi.presentation.screens.hotels

object HotelsMockFactory {

    fun getMockHotels(): List<HotelsModel> {
        val hotels = mutableListOf<HotelsModel>()
        hotels.add(
            HotelsModel(
                "http://www.harbor.digital/test/assets/lastmin/transatlantik/transatlantik-listing-cover-1.jpg",
                "Movenpick Resort & Spa El Gouna",
                "Gia de Izora, Tenerife, Canary Islands",
                1020,
                "€",
                "21.05",
                "27.05",
                true
            )
        )
        hotels.add(
            HotelsModel(
                "",
                "Dorisol Estrelicia",
                "Madeira, Madeira, Portugal",
                1350,
                "€",
                "1.05",
                "7.05",
                false
            )
        )
        return hotels
    }
//    let pathHost = "http://www.harbor.digital/test/assets/lastmin/"
//    let item = Hotel(name: "Transatlantic  Hotel & Spa")
//    item.location = "Turkey, Antalya, Kemer, Goynuk"
//    item.pathPhoto = pathHost + "transatlantik/transatlantik-listing-cover-1.jpg"
//    item.pathPhotoBig = pathHost + "transatlantik/transatlantik-tile--cover-2.jpg"
//    item.pathPhotoList = [pathHost + "transatlantik/transatlantik_full_1.jpg",
//    pathHost + "transatlantik/transatlantik_full_2.jpg",
//    pathHost + "transatlantik/transatlantik_full_3.jpg",
//    pathHost + "transatlantik/transatlantik_full_4.jpg",
//    pathHost + "transatlantik/transatlantik_full_5.jpg",
//    pathHost + "transatlantik/transatlantik_full_6.jpg",
//    pathHost + "transatlantik/transatlantik_full_7.jpg"]
//    item.distCity = "3.3km"
//    item.distSea = "200m"
//    item.distAirport = "34km"
//    item.info_main = "Designed to resemble a ship, this 5-star resort in Kemer enjoys a long stretch of sandy beach and an amazing pool scene with an aquapark. Personalised spa treatments include exotic massages.\nRooms at Transatlantik Hotel & Spa have a light, neutral décor. Each features a spacious seating area with a satellite LCD TV."
//    item.info_details = "•  Built in 2014, renovated in 20017-2018\n•  Area 186 000 square meters\n•  Rooms: 452\n•  4 a la carte restaurants\n•  4 bars\n•  7 swiiming pools\n•  Aquapark\n•  Miniclub\n•  Spa centre"
//
//    let pathHost = "http://www.harbor.digital/test/assets/lastmin/"
//    //http://www.harbor.digital/test/assets/lastmin/sherwood/sherwood_full_1.jpg
//    let item = Hotel(name: "Sherwood Exclusive Kemer")
//    item.location = "Turkey, Antalya, Kemer, Goynuk"
//    item.pathPhoto = pathHost + "sherwood/cover_list.jpg"
//    item.pathPhotoBig = pathHost + "sherwood/sherwood-slider-2.jpg"
//    item.pathPhotoList =
//    [pathHost + "sherwood/sherwood_full_1.jpg",
//    pathHost + "sherwood/sherwood_full_2.jpg",
//    pathHost + "sherwood/sherwood_full_3.jpg",
//    pathHost + "sherwood/sherwood_full_4.jpg",
//    pathHost + "sherwood/sherwood_full_5.jpg",
//    pathHost + "sherwood/sherwood_full_6.jpg",
//    pathHost + "sherwood/sherwood_full_7.jpg"]
//    item.distCity = "40km"
//    item.distSea = "100m"
//    item.distAirport = "45km"
//    item.info_main = "This property is 5 minutes walk from the beach. Offering extensive and unique facilities specifically tailored for kids, Sherwood Exclusive Kemer comes with a designated area equipped with movie screening sessions, kids sleeping rooms and variety of game room. You will find pools for children and babies. Eco-friendly activities are also offered such as tree and flower planting.\nThe hotel offers ultra all-inclusive service including meals at all its restaurants and selected beverages. Guests can enjoy Turkish, Italian, Chinese or fish specialties in à la carte restaurants. The bars serve a variety of drinks and beverages throughout the day. Antalya city centre is 40 km and Antalya Airport is 45 km from Sherwood Club Kemer. This property also has one of the best-rated locations in Goynuk! Guests are happier about it compared to other properties in the area."
//    item.info_details = "•  Built in 2014, renovated in 20017-2018\n•  Area 186 000 square meters\n•  Rooms: 452\n•  4 a la carte restaurants\n•  4 bars\n•  7 swiiming pools\n•  Aquapark\n•  Miniclub\n•  Spa centre"
}