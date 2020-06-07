#include <bits/stdc++.h>

using namespace std;

vector<string> split_string(string);

int twoPluses(vector<string> gr) {
    static const vector<string> &grid = gr;
    static const int n = grid.size(), m = grid[0].size();
    class plus {
        int x, y, len, area;
    public:
        plus(int x, int y) : x(x), y(y), len(0), area(0) {}
        int getArea() { return area; }
        bool grow() {
            if(len == 0 and grid[x][y] == 'G') {
                len = 1;
                area = 1;
                return true;
            }
            if(x - len >= 0 and x + len < n
            and y - len >= 0 and y + len < m
            and grid[x - len][y] == 'G' and grid[x + len][y] == 'G'
            and grid[x][y - len] == 'G' and grid[x][y + len] == 'G') {
                len += 1;
                area += 4;
                return true;
            }
            return false;
        }
        bool intersect(plus p) {
            int len = this->len - 1;
            if(x == p.x and x + len >= p.x - p.len and p.x + p.len >= x - len)
                return true;
            if(y == p.y and y + len >= p.y - p.len and p.y + p.len >= y - len)
                return true;
            if(p.x >= x - len and p.x <= x + len and p.y - p.len <= y and p.y + p.len >= y)
                return true;
            if(p.y >= y - len and p.y <= y + len and p.x - p.len <= x and p.x + p.len >= x)
                return true;
            return false;
        }
    };
    int maxAP = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            plus P(i, j);
            while(P.grow()) {
                cout << P.getArea() << " ";
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < m; j++) {
                        plus p(i, j);
                        while(p.grow() and !P.intersect(p));
                        maxAP = max(maxAP, P.getArea() * p.getArea());
                    }
                }
            } cout << endl;
        }
    }
    return maxAP;
}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string nm_temp;
    getline(cin, nm_temp);

    vector<string> nm = split_string(nm_temp);

    int n = stoi(nm[0]);

    int m = stoi(nm[1]);

    vector<string> grid(n);

    for (int i = 0; i < n; i++) {
        string grid_item;
        getline(cin, grid_item);

        grid[i] = grid_item;
    }

    int result = twoPluses(grid);

    fout << result << "\n";

    fout.close();

    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}
