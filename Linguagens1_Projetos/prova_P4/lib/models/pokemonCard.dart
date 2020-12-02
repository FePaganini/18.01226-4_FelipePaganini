class pokemonCard {
  List<Cards> cards;

  pokemonCard({this.cards});

  pokemonCard.fromJson(Map<String, dynamic> json) {
    if (json['cards'] != null) {
      cards = new List<Cards>();
      json['cards'].forEach((v) {
        cards.add(new Cards.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    if (this.cards != null) {
      data['cards'] = this.cards.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class Cards {
  String id;
  String name;
  int nationalPokedexNumber;
  String imageUrl;
  String imageUrlHiRes;
  List<String> types;
  String supertype;
  String subtype;
  String evolvesFrom;
  String hp;
  List<String> retreatCost;
  int convertedRetreatCost;
  String number;
  String artist;
  String rarity;
  String series;
  String set;
  String setCode;
  List<Attacks> attacks;
  List<Weaknesses> weaknesses;

  Cards(
      {this.id,
        this.name,
        this.nationalPokedexNumber,
        this.imageUrl,
        this.imageUrlHiRes,
        this.types,
        this.supertype,
        this.subtype,
        this.evolvesFrom,
        this.hp,
        this.retreatCost,
        this.convertedRetreatCost,
        this.number,
        this.artist,
        this.rarity,
        this.series,
        this.set,
        this.setCode,
        this.attacks,
        this.weaknesses});

  Cards.fromJson(Map<String, dynamic> json) {
    id = json['id'];
    name = json['name'];
    nationalPokedexNumber = json['nationalPokedexNumber'];
    imageUrl = json['imageUrl'];
    imageUrlHiRes = json['imageUrlHiRes'];
    types = json['types'].cast<String>();
    supertype = json['supertype'];
    subtype = json['subtype'];
    evolvesFrom = json['evolvesFrom'];
    hp = json['hp'];
    retreatCost = json['retreatCost'].cast<String>();
    convertedRetreatCost = json['convertedRetreatCost'];
    number = json['number'];
    artist = json['artist'];
    rarity = json['rarity'];
    series = json['series'];
    set = json['set'];
    setCode = json['setCode'];
    if (json['attacks'] != null) {
      attacks = new List<Attacks>();
      json['attacks'].forEach((v) {
        attacks.add(new Attacks.fromJson(v));
      });
    }
    if (json['weaknesses'] != null) {
      weaknesses = new List<Weaknesses>();
      json['weaknesses'].forEach((v) {
        weaknesses.add(new Weaknesses.fromJson(v));
      });
    }
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['id'] = this.id;
    data['name'] = this.name;
    data['nationalPokedexNumber'] = this.nationalPokedexNumber;
    data['imageUrl'] = this.imageUrl;
    data['imageUrlHiRes'] = this.imageUrlHiRes;
    data['types'] = this.types;
    data['supertype'] = this.supertype;
    data['subtype'] = this.subtype;
    data['evolvesFrom'] = this.evolvesFrom;
    data['hp'] = this.hp;
    data['retreatCost'] = this.retreatCost;
    data['convertedRetreatCost'] = this.convertedRetreatCost;
    data['number'] = this.number;
    data['artist'] = this.artist;
    data['rarity'] = this.rarity;
    data['series'] = this.series;
    data['set'] = this.set;
    data['setCode'] = this.setCode;
    if (this.attacks != null) {
      data['attacks'] = this.attacks.map((v) => v.toJson()).toList();
    }
    if (this.weaknesses != null) {
      data['weaknesses'] = this.weaknesses.map((v) => v.toJson()).toList();
    }
    return data;
  }
}

class Attacks {
  List<String> cost;
  String name;
  String text;
  String damage;
  int convertedEnergyCost;

  Attacks(
      {this.cost, this.name, this.text, this.damage, this.convertedEnergyCost});

  Attacks.fromJson(Map<String, dynamic> json) {
    cost = json['cost'].cast<String>();
    name = json['name'];
    text = json['text'];
    damage = json['damage'];
    convertedEnergyCost = json['convertedEnergyCost'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['cost'] = this.cost;
    data['name'] = this.name;
    data['text'] = this.text;
    data['damage'] = this.damage;
    data['convertedEnergyCost'] = this.convertedEnergyCost;
    return data;
  }
}

class Weaknesses {
  String type;
  String value;

  Weaknesses({this.type, this.value});

  Weaknesses.fromJson(Map<String, dynamic> json) {
    type = json['type'];
    value = json['value'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['type'] = this.type;
    data['value'] = this.value;
    return data;
  }
}
