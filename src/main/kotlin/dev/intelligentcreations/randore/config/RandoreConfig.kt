package dev.intelligentcreations.randore.config

import draylar.omegaconfig.api.Comment
import draylar.omegaconfig.api.Config

class RandoreConfig : Config {
    @Comment(value = "Defines if random ores will be generated")
    var random_ore_do_generate = true

    @Comment(value = "Defines the height that random ores should be generated under")
    var random_ore_height = 50

    @Comment(value = "Defines the vein size that random ores should be generated in")
    var random_ore_vein_size = 3

    @Comment(value = "Defines the number of random ore veins that should be generated per chunk")
    var random_ore_vein_number = 13

    @Comment(value = "Defines if deepslate random ores will be generated")
    var deepslate_random_ore_do_generate = true

    @Comment(value = "Defines the height that deepslate random ores should be generated under")
    var deepslate_random_ore_height = 10

    @Comment(value = "Defines the vein size that deepslate random ores should be generated in")
    var deepslate_random_ore_vein_size = 4

    @Comment(value = "Defines the number of deepslate random ore veins that should be generated per chunk")
    var deepslate_random_ore_vein_number = 8

    @Comment(value = "Defines if nether random ores will be generated")
    var nether_random_ore_do_generate = true

    @Comment(value = "Defines the height that nether random ores should be generated under")
    var nether_random_ore_height = 128

    @Comment(value = "Defines the vein size that nether random ores should be generated in")
    var nether_random_ore_vein_size = 5

    @Comment(value = "Defines the number of nether random ore veins that should be generated per chunk")
    var nether_random_ore_vein_number = 10

    @Comment(value = "Defines if end random ores will be generated")
    var end_random_ore_do_generate = true

    @Comment(value = "Defines the height that end random ores should be generated under")
    var end_random_ore_height = 80

    @Comment(value = "Defines the vein size that end random ores should be generated in")
    var end_random_ore_vein_size = 7

    @Comment(value = "Defines the number of end random ore veins that should be generated per chunk")
    var end_random_ore_vein_number = 10

    override fun getName(): String {
        return "randore"
    }
}