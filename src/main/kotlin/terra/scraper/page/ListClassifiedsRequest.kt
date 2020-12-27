package terra.scraper.page

import terra.scraper.URLRequest

class ListClassifiedsRequest(
        val adType: ClassifiedType = ClassifiedType.ALL,
        val category: Category = Category.ALL_HERP_ADS,
        val region: Region = Region.ANYWHERE,
        val skipCnt: Int = 0,
        val fulltextSearch: String = "") : URLRequest {

    val baseUrl: String = "https://www.terraristik.com/tb/list_classifieds_int.php"

    override val url: String
        get() = baseUrl +
                "?type_selection=${adType.paramValue}" +
                "&category_selection=${category.paramValue}" +
                "&region=${region}" +
                "&ftsearch=${fulltextSearch}" +
                "&split=${skipCnt}"

}

enum class Region(override val paramValue: String,
                  override val displayName: String) : ParameterEnum {
    ANYWHERE("", "Anywhere"),
    GERMANY("DEU", "Germany"),
    AUSTRIA("AUT", "Austria"),
    NETHERLANDS("NLD", "Netherlands"),
    SWITZERLAND("CHE", "Switzerland"),
    HUNGARY("HUN", "Hungary"),
    CZECH_REPUBLIC("CZE", "Czech Republic"),
    SLOVAKIA("SVK", "Slovakia"),
    ITALY("ITA", "Italy"),
    POLAND("POL", "Poland"),
    DENMARK("DNK", "Denmark"),
    UK("GBR", "UK"),
    SPAIN("ESP", "SPAIN"),
    USA("USA", "USA")
}

enum class ClassifiedType(override val paramValue: String,
                          override val displayName: String) : ParameterEnum {
    ALL("0", "All types"),
    OFFER("1", "Offer"),
    WANTED("2", "Wanted"),
    TRADE("3", "Exchange")
}

enum class Category(override val paramValue: String,
                    override val displayName: String) : ParameterEnum {
    ALL_HERP_ADS("01", "All herp ads"),
    REPTILES("01.01", "Reptiles"),
    SNAKES("01.01.01", "Snakes"),
    BOAS("01.01.01.01", "Boas"),
    PYTHONS("01.01.01.02", "Pythons"),
    BALL_PYTHONS("01.01.01.02.01", "Ball Pythons"),
    COLUBRIDS("01.01.01.03", "Colubrids"),
    LIZARDS("01.01.02", "Lizards"),
    AGAMA("01.01.02.01", "Agama"),
    OTHER_AGAMA("01.01.02.01.01", "Other Agama"),
    BEARDED_DRAGONS("01.01.02.01.02", "Bearded dragons"),
    CHAMELEONS("01.01.02.02", "Chamaeleons"),
    GECKOS("01.01.02.03", "Geckos"),
    SKINKS("01.01.02.08", "Skinks"),
    OTHER_LIZARDS("01.01.02.10", "other lizards"),
    TURTLES_AND_TORTOISES("01.01.03", "Turtles and Tortoises"),
    TORTOISES("01.01.03.01", "Tortoises"),
    TURTLES("01.01.03.02", "Turtles"),
    AMPHIBIANS("01.02", "amphibians"),
    FROGS("01.02.01", "frogs"),
    NEWTS_AND_SALAMANDERS("01.02.02", "newts and salamanders"),
    SALAMANDER("01.02.02.02", "salamander"),
    INVERTEBRATES("01.03", "Invertebrates"),
    INSECTS("01.03.01", "Insects"),
    SPIDERS_AND_SCORPIONS("01.03.02", "Spiders and Scorpions"),
    BIRD_SPIDERS("01.03.02.01", "bird spiders"),
    OTHER_SPIDERS("01.03.02.02", "other spiders"),
    SCORPIONS("01.03.03", "Scorpions"),
    MYRIAPODA("01.03.04", "Myriapoda"),
    CRUSTRACEAE_NON_AQUATIC("01.03.05", "Crustraceae non aquatic"),
    MOLLUSCA("01.03.06", "Mollusca"),
    OTHER_ARTHROPODA("01.03.07", "other Arthropoda"),
    EXOTIC_MAMMALS("01.04", "Exotic mammals"),
    FEEDER_ANIMALS("01.05", "Feeder animals"),
    ENCLOSURES("01.06", "Enclosures"),
    SUPPLIES("01.07", "Supplies"),
    BOOKS_AND_MAGAZINES("01.08", "Books & Magazines"),
    OTHER("01.09", "Other"),
    AQUARISTICS("10", "aquaristics"),
    ORNAMENTAL_FISH("10.01", "ornamental fish"),
    AQUATIC_INVERTEBRATES("10.02", "aquatic invertebrates"),
    SHRIMP_AND_OTHER_CRUSTACEAN("10.02.01", "shrimp and other crustacean"),
    SNAILS_AND_MUSSELS("10.02.02", "snails and mussels"),
    AQUATIC_PLANTS("10.03", "aquatic plants"),
    TANKS("10.04", "tanks"),
    AQ_SUPPLIES("10.05", "supplies")
}