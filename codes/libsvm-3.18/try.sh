./svm-train -t 0 "./testandtrain/"$1"_traindata"
./svm-predict "./testandtrain/"$1"_testdata" $1"_traindata.model" "output"
