import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

import 'package:prova_P4/pages/cardView.dart';

final controladorPokemon = TextEditingController();
class cardSearch extends StatelessWidget {
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
        ElevatedButton(onPressed: () {
          Navigator.push(
            context,
            MaterialPageRoute(builder: (context) =>
                cardView(pokemon: controladorPokemon.text)),
          );
        }, child: Text("Pesquisar")
        )
      ]),
    );
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