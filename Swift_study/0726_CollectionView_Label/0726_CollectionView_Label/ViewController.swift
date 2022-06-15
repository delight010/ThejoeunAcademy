//
//  ViewController.swift
//  0726_CollectionView_Label
//
//  Created by Seong A Oh on 2021/07/26.
//

import UIKit

var list = ["유비", "관우", "장비", "조조", "여포", "동탁", "초선", "손견", "장양", "손책"]

class ViewController: UIViewController {
    @IBOutlet weak var collectionView: UICollectionView! // UICollectionView인지 확인
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        // extension으로 설정한 것을 실행
        collectionView.dataSource = self
        collectionView.delegate = self
    }
    
    // *** 위에 실행했던 View가 닫히고 다시 띄워질 때 ***
    override func viewWillAppear(_ animated: Bool) {
        collectionView.reloadData()
    }
    
    // list 값 넘기기
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "sgDetail"{
            // sender가 n번지인 것을 알고있음
            // segue 경로 이름이 "sgDetail"이면,
            let cell = sender as! CollectionViewCell // CollectionViewCell로 변환
            let indexPath = self.collectionView.indexPath(for: cell) // cell의 정보를 가져옴
            let detailView = segue.destination as! DetailViewController // segue를 통하여 instance 생성
            detailView.receiveItems(list[indexPath!.row])
        }
    }


} // ViewController


//UICollectionView의 모양, 기능 설정
extension ViewController: UICollectionViewDataSource, UICollectionViewDelegate{
    
    // cell의 갯수 return
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return list.count
    }
    
    // cell 구성(색깔 등)
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        // Identifier가 myCell에 해당하는 cell에
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "myCell", for: indexPath) as! CollectionViewCell
        // as! UICollectionViewCell는 Type 변환
        
        cell.backgroundColor = .lightGray // UIColor 생략하여 씀
        cell.lblHuman.text = list[indexPath.row] // list Data를 입력
        cell.lblHuman.backgroundColor = .yellow // text 글자의 배경색
        
        return cell
        
    }
}


// Cell Layout 정의
extension ViewController: UICollectionViewDelegateFlowLayout{
    
    // 위 아래 간격 minimumLineSpacingForSectionAt
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 1
    }
    
    // 옆 간격 minimumInteritemSpacingForSectionAt
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumInteritemSpacingForSectionAt section: Int) -> CGFloat {
        return 1
    }
    
    // cell 사이즈 (옆 라인을 고려하여 설정) sizeForItemAt
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        // 3등분하여 배치(1행당), 옆 간격이 1이므로 1를 빼줌
        let width = collectionView.frame.width / 3 - 1
        let size = CGSize(width: width, height: width) // 정사각형
        
        return size
    }
    
}
