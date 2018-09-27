#include<iostream>
#include<vector>
#include <string.h>
#include <stdio.h>
#include <iostream>
#include <fstream>
#include <vector>
#include "rapidxml.hpp"

using namespace rapidxml;
using namespace std;


int main(void)
{
	int i = 0;
	string input_xml;
	string line;
	ifstream in("game.xml");

	while(getline(in,line))
    		input_xml += line;

// make a safe-to-modify copy of input_xml
// (you should never modify the contents of an std::string directly)
	vector<char> xml_copy(input_xml.begin(), input_xml.end());
	xml_copy.push_back('\0');

// only use xml_copy from here on!
	xml_document<> doc;

	doc.parse<parse_declaration_node | parse_no_data_nodes>(&xml_copy[0]);
	
	xml_node<>* cur_node = doc.first_node("game");
	cur_node = cur_node->first_node("title");
	string title = cur_node->value(); 
	cout << endl << title << endl << endl;

//loop through nodes of xml document copying text into string variables, print at end of each loop
	for(i = 0; i <= 3; i++)
	{
		cur_node = cur_node->next_sibling("description");
		string descriptioni = cur_node->value();
		cur_node = cur_node->next_sibling("question");
		string questioni = cur_node->value();
		cur_node = cur_node->next_sibling("answer");
		string answer1i = cur_node->value();
		cur_node = cur_node->next_sibling("next");
		string next1i = cur_node->value();
		cur_node = cur_node->next_sibling("answer");
		string answer2i = cur_node->value();
		cur_node = cur_node->next_sibling("next");
		string next2i = cur_node->value();

		cout << descriptioni << endl << questioni << endl << answer1i << endl << 
		next1i << endl << answer2i << endl << next2i << endl;
	}

	return 0;

}

