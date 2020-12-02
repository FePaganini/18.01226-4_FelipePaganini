import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';
import 'package:prova_P4/models/minhaCarta.dart';

import 'package:prova_P4/models/pokemonCard.dart';
import 'package:prova_P4/utility/NetworkHelper.dart';
import 'package:prova_P4/pages/cardView.dart';

final controladorPokemon = TextEditingController();
class cardSearch extends StatelessWidget {
  minhaCarta card;
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amber,
      body: Stack(children: [
        Padding(
          padding: const EdgeInsets.all(50.0),
          child: Container(
              height: 100,
              child: Center(child: Image.network("https://logodownload.org/wp-content/uploads/2017/08/pokemon-logo.png"))
          ),
        ),
        txtField(controladorPokemon),
        ElevatedButton(onPressed: () async {
          await requestApi();
            trocarTela(context);

        }, child: Text("Pesquisar")
        )
      ]),
    );
}

  void trocarTela(BuildContext context){
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) =>
          cardView(card: card)),
    );
}


  Future<pokemonCard> requestApi() async {
    var requisicao = NetworkHelper(url: "https://api.pokemontcg.io/v1/cards?name=" + controladorPokemon.text + "&pageSize=1");
    var json = pokemonCard.fromJson(await requisicao.getData());
    print(json.cards[0].imageUrlHiRes);

    card = new minhaCarta(json.cards[0].imageUrlHiRes, json.cards[0].series, json.cards[0].set, json.cards[0].nationalPokedexNumber.toString(), json.cards[0].hp, json.cards[0].name);

  }
}

Widget txtField(TextEditingController nomePokemon){
  return Padding(
    padding: EdgeInsets.all(70.0),
    child: TextField(
      controller: nomePokemon,
      decoration: InputDecoration(
        hintStyle: TextStyle(color: Colors.white),
        hintText: 'Pesquise um nome de Pokémon',
        border: const OutlineInputBorder(),
      ),
    ),
  );
}


