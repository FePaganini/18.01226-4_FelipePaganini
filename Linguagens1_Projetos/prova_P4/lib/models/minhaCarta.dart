class minhaCarta {
  String _name;
  String _imageUrlHiRes;
  String _hp;
  String _nationalPokedexNumber;
  String _set;
  String _series;


  String get imageUrlHiRes => _imageUrlHiRes;

  String get name => _name;

  String get hp => _hp;

  String get nationalPokedexNumber => _nationalPokedexNumber;

  String get set => _set;

  String get series => _series;

  minhaCarta(this._imageUrlHiRes, this._hp, this._nationalPokedexNumber,
      this._set, this._series, this._name);
}