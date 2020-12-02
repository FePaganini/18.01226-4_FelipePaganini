import 'dart:convert';

import 'package:prova_P4/models/minhaCarta.dart';
import 'package:prova_P4/models/pokemonCard.dart';
import 'package:prova_P4/utility/NetworkHelper.dart';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'package:flutter/rendering.dart';


class cardView extends StatelessWidget {

  minhaCarta card;

  cardView({Key key, @required this.card}) : super(key: key);

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
          Positioned(
            top: 130,
            left: 120,
            child: Text("RESULTADO DA PESQUISA",
            style: TextStyle(fontSize: 30, height: 4, color: Colors.black, fontWeight: FontWeight.bold),
            ),
          ),
          Center(child: Image.network(card.imageUrlHiRes, height: 550,)),
          Positioned(
            top: 850,
            left: 70,
            child: Column(
              children: [
                Text("NAME: " +  card.name,style: TextStyle(fontSize: 30, color: Colors.black)),
                Text("HP: " + card.hp, style: TextStyle(fontSize: 30, color: Colors.black)),
                Text("NATIONAL POKEDEX NUMBER: " + card.nationalPokedexNumber,style: TextStyle(fontSize: 30, color: Colors.black)),
                Text("SET: " + card.set,style: TextStyle(fontSize: 30, color: Colors.black)),
                Text("SERIES: " + card.series,style: TextStyle(fontSize: 30, color: Colors.black)),
              ],
            ),
          ),
        ]),
    );
  }

}