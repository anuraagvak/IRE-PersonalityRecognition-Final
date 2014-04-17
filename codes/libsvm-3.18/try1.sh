./svm-train -t 0 ./testandtrain/opn_traindata > oooo
./svm-predict ./testandtrain/opn_testdata opn_traindata.model output1
./svm-train -t 0 ./testandtrain/con_traindata > oooo
./svm-predict ./testandtrain/con_testdata con_traindata.model output2
./svm-train -t 0 ./testandtrain/ext_traindata > oooo
./svm-predict ./testandtrain/ext_testdata ext_traindata.model output3
./svm-train -t 0 ./testandtrain/agr_traindata > oooo
./svm-predict ./testandtrain/agr_testdata agr_traindata.model output4
./svm-train -t 0 ./testandtrain/neu_traindata > oooo
./svm-predict ./testandtrain/neu_testdata neu_traindata.model output5

./svm-train -t 1 ./testandtrain/opn_traindata > oooo
./svm-predict ./testandtrain/opn_testdata opn_traindata.model output6
./svm-train -t 1 ./testandtrain/con_traindata > oooo
./svm-predict ./testandtrain/con_testdata con_traindata.model output7
./svm-train -t 1 ./testandtrain/ext_traindata > oooo
./svm-predict ./testandtrain/ext_testdata ext_traindata.model output8
./svm-train -t 1 ./testandtrain/agr_traindata > oooo
./svm-predict ./testandtrain/agr_testdata agr_traindata.model output9
./svm-train -t 1 ./testandtrain/neu_traindata > oooo
./svm-predict ./testandtrain/neu_testdata neu_traindata.model output10

cat output1 >> output
cat output6 >> output
cat output2 >> output
cat output7 >> output
cat output3 >> output
cat output8 >> output
cat output4 >> output
cat output9 >> output
cat output5 >> output
cat output10 >> output
