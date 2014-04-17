javac ~/workspace_wordnet/final_ire_major/src/precission.java 

./svm-train -t 0 ./testandtrain/opn_traindata > oooo
./svm-predict ./testandtrain/opn_testdata opn_traindata.model output_opn 
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission opn; cd - > ooo; echo;

./svm-train -t 0 ./testandtrain/con_traindata > oooo
./svm-predict ./testandtrain/con_testdata con_traindata.model output_con
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission con; cd - > ooo; echo;

./svm-train -t 0 ./testandtrain/ext_traindata > oooo
./svm-predict ./testandtrain/ext_testdata ext_traindata.model output_ext
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission ext; cd - > ooo; echo;

./svm-train -t 0 ./testandtrain/agr_traindata > oooo
./svm-predict ./testandtrain/agr_testdata agr_traindata.model output_agr
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission agr; cd - > ooo; echo;

./svm-train -t 0 ./testandtrain/neu_traindata > oooo
./svm-predict ./testandtrain/neu_testdata neu_traindata.model output_neu
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission neu; cd - > ooo; echo;


./svm-train -t 1 ./testandtrain/opn_traindata > oooo
./svm-predict ./testandtrain/opn_testdata opn_traindata.model output_opn
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission opn; cd - > ooo; echo;

./svm-train -t 1 ./testandtrain/con_traindata > oooo
./svm-predict ./testandtrain/con_testdata con_traindata.model output_con
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission con; cd - > ooo; echo;

./svm-train -t 1 ./testandtrain/ext_traindata > oooo
./svm-predict ./testandtrain/ext_testdata ext_traindata.model output_ext
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission ext; cd - > ooo; echo;

./svm-train -t 1 ./testandtrain/agr_traindata > oooo
./svm-predict ./testandtrain/agr_testdata agr_traindata.model output_agr
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission agr; cd - > ooo; echo;

./svm-train -t 1 ./testandtrain/neu_traindata > oooo
./svm-predict ./testandtrain/neu_testdata neu_traindata.model output_neu
cd  /home/guru/workspace_wordnet/final_ire_major/src/ ; java precission neu; cd - > ooo; echo;


