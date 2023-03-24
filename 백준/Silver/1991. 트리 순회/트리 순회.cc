#include <iostream>
#include <map>
using namespace std;

map<char, pair<char, char>> tree;

void preorder(char v) {
	if (v == '.') {
		return;
	}

	cout << v;
	preorder(tree[v].first);
	preorder(tree[v].second);
}

void inorder(char v) {
	if (v == '.') {
		return;
	}

	inorder(tree[v].first);
	cout << v;
	inorder(tree[v].second);
}

void postorder(char v) {
	if (v == '.') {
		return;
	}
	
	postorder(tree[v].first);
	postorder(tree[v].second);
	cout << v;
}
int main() {
	int n;
	char root, left, right;

	cin >> n;
	while (n--) {
		cin >> root >> left >> right;
		tree[root] = { left, right };
	}

	preorder('A');
	cout << '\n';
	inorder('A');
	cout << '\n';
	postorder('A');
	return 0;
}